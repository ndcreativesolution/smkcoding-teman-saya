package id.ndcreative.temansaya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_list_teman.*

class ListTemanFragment : Fragment() {

    lateinit var listTeman: ArrayList<Teman>

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
        initView()
    }

    private fun initView() {
        fabAddFriend.setOnClickListener {
            (activity as MainActivity).tampilkanTambahTeman()
        }

        dataTemanDummy()
        tampilTeman()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

    private fun dataTemanDummy() {
        listTeman = ArrayList()
        listTeman.add(
            Teman(
                "Muhammad", "Laki-laki", "ade@gmail.com", "085719004268",
                "Bandung"
            )
        )
        listTeman.add(
            Teman(
                "Al Harits", "Laki-laki", "rifaldi@gmail.com",
                "081213416171", "Bandung"
            )
        )
    }

    private fun tampilTeman() {
        listMyFriends.layoutManager = LinearLayoutManager(activity)
        listMyFriends.adapter = TemanAdapter(activity!!, listTeman)
    }

}
