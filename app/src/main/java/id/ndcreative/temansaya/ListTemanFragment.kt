package id.ndcreative.temansaya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_list_teman.*

class ListTemanFragment : Fragment() {

    private var listTeman: List<Teman>? = null
    private var temanDao: TemanDao? = null
    private var db: AppDatabase? = null

    companion object {
        fun newInstance(): ListTemanFragment {
            return ListTemanFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_teman, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(activity!!)
        temanDao = db?.temanDao()

    }

    private fun initView() {
        fabAddFriend.setOnClickListener {
            (activity as MainActivity).tampilkanTambahTeman()
        }
        ambilDataTeman()
    }

    private fun ambilDataTeman() {
        listTeman = ArrayList()
        temanDao ?. ambilSemuaTeman ()?.observe(this, Observer { r ->
            listTeman = r as ArrayList<Teman>?
            when {
                listTeman?.size == 0 -> tampilToast("Belum ada data teman")
                else -> {
                    tampilTeman()
                }
            }
        })
    }

    private fun tampilToast(message: String) {
        Toast.makeText(activity!!, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

    private fun tampilTeman() {
        listMyFriends.layoutManager = LinearLayoutManager(activity)
        listMyFriends.adapter = TemanAdapter(activity!!, (listTeman as ArrayList<Teman>?)!!)
    }
}
