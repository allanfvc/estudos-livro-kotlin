package br.com.livrokotlin.listadecompras

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.livrokotlin.R

class ItemsAdapter:RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    val items = mutableListOf<ItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun addItem(item: ItemModel) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun removeItem(item: ItemModel) {
        val position = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(position)
    }

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<Button>(R.id.button)
        fun bind(item: ItemModel) {
            textView.text = item.name
            button.setOnClickListener { item.onRemove(item) }
        }
    }
}