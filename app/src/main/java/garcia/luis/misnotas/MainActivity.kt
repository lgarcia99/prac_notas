package garcia.luis.misnotas

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nota_layout.view.*

class MainActivity : AppCompatActivity() {
    var notas = ArrayList<Nota>()
    lateinit var adaptador: AdapterNotas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notasDePrueba()

        adaptador = AdapterNotas(this, notas)
        list_view.adapter = adaptador
    }

    fun notasDePrueba() {
        notas.add(Nota("prueba 1", "contenido de la nota 1"))
        notas.add(Nota("prueba 2", "contenido de la nota 2"))
        notas.add(Nota("prueba 3", "contenido de la nota 3"))
    }

    class AdapterNotas : BaseAdapter {
        var context: Context
        var notas: ArrayList<Nota>

        constructor(context: Context, notas: ArrayList<Nota>) {
            this.context = context
            this.notas = notas
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var inflador = LayoutInflater.from(context)
            var vista = inflador.inflate(R.layout.nota_layout, null)
            var nota = notas[position]

            vista.tv_titulo_det.text = nota.titulo
            vista.tv_contenido_det.text = nota.contenido

            return vista
        }

        override fun getItem(position: Int): Any {
            return notas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return notas.size
        }
    }
}
