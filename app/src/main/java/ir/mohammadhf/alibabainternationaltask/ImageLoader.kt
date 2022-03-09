package ir.mohammadhf.alibabainternationaltask

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class ImageLoader @Inject constructor() {

    fun load(context: Context, imageUrl: String, imageView: ImageView) =
        Glide.with(context).load(imageUrl).into(imageView)
}