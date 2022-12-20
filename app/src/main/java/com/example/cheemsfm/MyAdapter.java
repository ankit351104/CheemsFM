package com.example.cheemsfm;
import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cheemsfm.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class MyAdapter extends RecyclerView.Adapter<PlaceViewHolder> {
    private Context context;
    ArrayList images;
    private Activity activity;

    MyAdapter(Context context, ArrayList images, Activity activity) {
        this.context = context;
        this.images = images;
        this.activity = activity;
    }


    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        ArrayList<Uri> imageUris = new ArrayList<Uri>();
        Resources resources = context.getResources();
        /*Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + resources.getResourcePackageName(R.drawable.m41) + '/' + resources.getResourceTypeName(R.drawable.m41)
                + '/' + resources.getResourceEntryName(R.drawable.m41) );*/
        //imageUris.add(R.drawable.m41); // Add your image URIs here
        //imageUris.add(uri);
        int res = (int) images.get(position);
        holder.images.setImageResource(res);
        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveImage(holder);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.images.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                shareImageandText(bitmap);
                /*Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey!! Check out this meme i found on Cheems FM.\"+\n" +
                        "                        \"\\nYou can download the app by clicking this link: INSERT LINK HERE");
                shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
                shareIntent.setType("image/*");
                context.startActivity(Intent.createChooser(shareIntent, "Share image via:"));*/
                /*Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
                shareIntent.setType("image/*");
                context.startActivity(Intent.createChooser(shareIntent, "share via"));*/

                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Hey!! Check out this meme i found on Cheems FM."+
                        "\nYou can download the app by clicking this link: INSERT LINK HERE ");
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Send To"));*/
            }
    });
    }
    private void shareImageandText(Bitmap bitmap) {
        Uri uri = getmageToShare(bitmap);
        Intent intent = new Intent(Intent.ACTION_SEND);

        // putting uri of image to be shared
        intent.putExtra(Intent.EXTRA_STREAM, uri);

        // adding text to share
        intent.putExtra(Intent.EXTRA_TEXT, "Hey!! Check out this meme i found on Cheems FM."+
                "                      \n\nYou can download the app by clicking this link: INSERT LINK HERE");

        // Add subject Here
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

        // setting type to image
        intent.setType("image/*");

        // calling startactivity() to share
        context.startActivity(Intent.createChooser(intent, "Share Via"));
    }
    private Uri getmageToShare(Bitmap bitmap) {
        File imagefolder = new File(context.getCacheDir(), "images");
        Uri uri = null;
        try {
            imagefolder.mkdirs();
            File file = new File(imagefolder, "shared_image.png");
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
            uri = FileProvider.getUriForFile(this.context, "com.company.app.fileprovider", file);
        } catch (Exception e) {
            //Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return uri;
    }

    private void saveImage(PlaceViewHolder holder){
        Toast.makeText(context, "Downloading", Toast.LENGTH_SHORT).show();
        ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        FileOutputStream fileOutputStream = null;
        File file =getDisc();
        if(!file.exists() && !file.mkdirs()){
            file.mkdirs();

        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmsshhmmss");
        String date = simpleDateFormat.format(new Date());
        String name = "IMG" + date + ".jpg";
        String file_name = file.getAbsolutePath() + "/" + name;
        File new_file = new File(file_name);

        try{
            BitmapDrawable draw = (BitmapDrawable) holder.images.getDrawable();
            Bitmap bitmap = draw.getBitmap();
            fileOutputStream = new FileOutputStream(new_file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            Toast.makeText(context, "Downloaded this Meme Successfully \uD83E\uDD73", Toast.LENGTH_SHORT).show();
            fileOutputStream.flush();
            fileOutputStream.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        refreshGallery(new_file);

    }
    private File getDisc(){
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return  new File(file,"FirebaseTutorial");
    }
    private void refreshGallery(File file){
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }


    @Override
    public int getItemCount() {
        return images.size();
    }
}


class PlaceViewHolder extends RecyclerView.ViewHolder {

    ImageView images, btnDownload;
    Button share;

    PlaceViewHolder(View itemView) {
        super(itemView);

        images = itemView.findViewById(R.id.ivPlace);
        share = itemView.findViewById(R.id.btnShare);
        btnDownload = itemView.findViewById(R.id.btnDownload);
    }
}