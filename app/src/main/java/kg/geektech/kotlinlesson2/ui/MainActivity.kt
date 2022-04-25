package kg.geektech.kotlinlesson2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil.isValidUrl
import android.widget.Toast
import com.bumptech.glide.Glide
import kg.geektech.kotlinlesson2.R
import kg.geektech.kotlinlesson2.databinding.ActivityMainBinding
import kg.geektech.kotlinlesson2.extension.isValidUrlImage
import kg.geektech.kotlinlesson2.extension.loadImage
import kg.geektech.kotlinlesson2.extension.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private var url = mutableListOf<String>().apply {
            add("https://i.pinimg.com/236x/c3/92/2a/c3922a862508bc91553956a3959ee2eb.jpg")
            add("https://i.pinimg.com/564x/27/18/34/271834a67b217b6e96d04883dc1f9060.jpg")
            add("https://i.pinimg.com/236x/27/b6/8a/27b68a6e05c65e197e3efdafeec0d33f.jpg")
            add("https://i.pinimg.com/236x/88/a5/fc/88a5fc0752831c98fb9d136f523c631f.jpg")
            add("https://i.pinimg.com/236x/5b/f5/02/5bf50218013adf7a83dccb90dc3430dd.jpg")
            add("https://i.pinimg.com/236x/ce/a9/54/cea9544b420166e9249202c806004cc5.jpg")
            add("https://i.pinimg.com/236x/7c/42/35/7c42355f6bf9991edbbda61b7ad5c39f.jpg")
            add("https://i.pinimg.com/236x/d7/3f/0e/d73f0e15a3a2635d7e6ad39642abb98d.jpg")
            add("https://i.pinimg.com/236x/a5/33/cd/a533cd056ed128ce9e1838655202de3f.jpg")
            add("https://i.pinimg.com/236x/d1/ef/21/d1ef2170c89dff067b0ddd9cc7c24536.jpg")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickSubmit()
        onClickRandom()

    }

    private fun onClickRandom() {
        binding.btnRandom.setOnClickListener {
            binding.imageView.loadImage(url.random())
        }
    }

    private fun onClickSubmit() {
        binding.btnSubmit.setOnClickListener {
            if (isValidUrlImage(binding.editText.text.toString())) {
                url.add(binding.editText.text.toString())
                showToast("picture has been successfully added to the array!")
            } else {
                showToast(R.string.Error.toString())
            }
           binding.editText.text.clear()
        }
    }
}