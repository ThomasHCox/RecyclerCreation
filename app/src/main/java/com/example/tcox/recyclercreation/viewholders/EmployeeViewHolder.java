package com.example.tcox.recyclercreation.viewholders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.models.MobileEngineer;

import org.w3c.dom.Text;

import java.io.InputStream;

/**
 * Created by tcox on 12/1/17.
 */

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private ImageView mEmployeeAvatar;
    private TextView mEmployeeName;
    private TextView mEmployeeTitle;
    private TextView mEmployeeStartDate;
    private TextView mEmployeeBirthday;
    private TextView mEmployeeHobbies;
    private TextView mEmployeeProject;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mEmployeeAvatar = (ImageView) itemView.findViewById(R.id.EmployeeAvatar);
        mEmployeeName = (TextView) itemView.findViewById(R.id.employeeName);
        mEmployeeTitle = (TextView) itemView.findViewById(R.id.employeeTitle);
        mEmployeeStartDate = (TextView) itemView.findViewById(R.id.employeeStartDate);
        mEmployeeBirthday = (TextView) itemView.findViewById(R.id.employeeBirthDate);
        mEmployeeProject = (TextView) itemView.findViewById(R.id.employeeProject);
        mEmployeeHobbies = (TextView) itemView.findViewById(R.id.employeeHobbies);
    }

    public void bind(final MobileEngineer engineer) {
        mEmployeeTitle.setText(engineer.getPosition());
        mEmployeeBirthday.setText(engineer.getBirthdate());
        mEmployeeName.setText(engineer.getName());
        mEmployeeStartDate.setText(engineer.getStartDate());
        mEmployeeProject.setText(engineer.getProject());
        mEmployeeHobbies.setText(engineer.getHobbies());
        new DownloadImageTask(mEmployeeAvatar).execute(engineer.getAvatar());
//        mEmployeeAvatar.setImageBitmap(DownloadImageTask.execute(engineer.getAvatar()););
    }
}


class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}
