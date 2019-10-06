package id.ndcreative.temansaya

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.my_friends_item.*


/**
 * Created by Umar Fadil on 05,Oct,2019
 * ND Creative Solution
 * id.ndcreativesolution@gmail.com
 */

class TemanAdapter(private val context: Context, private val items: List<Teman>) :
    RecyclerView.Adapter<TemanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        context, LayoutInflater.from(context).inflate(
            R.layout.my_friends_item, parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    override fun getItemCount(): Int = items.size
    class ViewHolder(val context: Context, override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(item: Teman) {
            txtFriendName.text = item.nama
            txtFriendEmail.text = item.email
            txtFriendTelp.text = item.telp
            Glide.with(context).load(item.image).into(imgProfile)
        }
    }

}