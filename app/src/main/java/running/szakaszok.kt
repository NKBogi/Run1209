package running

class SzakaszokAdapter {class SzakaszokAdapter(
    private val szakaszok: List<Szakasz>
) : RecyclerView.Adapter<SzakaszokAdapter.SzakaszViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SzakaszViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.szakasz_elem, parent, false)
        return SzakaszViewHolder(view)
    }

    override fun onBindViewHolder(holder: SzakaszViewHolder, position: Int) {
        val szakasz = szakaszok[position]
        holder.szakaszNev.text = szakasz.szakaszNev
        holder.futóNev.text = szakasz.futóNev
        holder.kezdesIdopont.text = szakasz.kezdesIdopont
        holder.tavolsag.text = szakasz.tavolsag
    }

    override fun getItemCount(): Int {
        return szakaszok.size
    }

    class SzakaszViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val szakaszNev: TextView = itemView.findViewById(R.id.szakasz_nev)
        val futóNev: TextView = itemView.findViewById(R.id.futo_nev)
        val kezdesIdopont: TextView = itemView.findViewById(R.id.kezdes_idopont)
        val tavolsag: TextView = itemView.findViewById(R.id.tavolsag)
    }
}
}