package uz.futuresoft.namozvaqtlari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import uz.futuresoft.namozvaqtlari.databinding.ActivityMainBinding
import uz.futuresoft.namozvaqtlari.utilits.AppValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        getData()
    }

    private fun initFields() {
        initFirebase()
    }

    private fun getData() {
        REF_DATABASE_ROOT.child(NODE_TIMES).addValueEventListener(AppValueEventListener {
            TIMES = it.getValue(TimesModel::class.java) ?: TimesModel()
            binding.bomdodTime.text = TIMES.bomdod
            binding.quyoshTime.text = TIMES.quyosh
            binding.peshinTime.text = TIMES.peshin
            binding.asrTime.text = TIMES.asr
            binding.shomTime.text = TIMES.shom
            binding.xuftonTime.text = TIMES.xufton
        })
    }
}