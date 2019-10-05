package id.ndcreative.temansaya

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tampilkanListTeman()
    }

    private fun gantiFragment(fragmentManager: FragmentManager, fragment: Fragment, frameId: Int) {

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)
        transaction.commit()

    }

    fun tampilkanListTeman() {
        gantiFragment(supportFragmentManager, ListTemanFragment.newInstance(),
            R.id.contentFrame)
    }

    fun tampilkanTambahTeman() {
        gantiFragment(supportFragmentManager, TambahTemanFragment.newInstance(),
            R.id.contentFrame)
    }
}
