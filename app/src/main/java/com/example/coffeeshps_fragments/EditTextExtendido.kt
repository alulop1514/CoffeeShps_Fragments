
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText


class EditTextExtendido : AppCompatEditText {
    private var pNegro: Paint? = null
    private var pBlanco: Paint? = null

    //funcionamiento en distintas densidades de pantalla
    //escala = getResources().getDisplayMetrics().density;
    // Hay que reescribir siempre los constructores heredados.
    // En este caso son tres
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        inicializaPinceles()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        inicializaPinceles()
    }

    constructor(context: Context) : super(context) {
        inicializaPinceles()
    }

    private fun inicializaPinceles() {
        pNegro = Paint(Paint.ANTI_ALIAS_FLAG)
        pNegro!!.setColor(Color.BLACK)
        pNegro!!.setStyle(Paint.Style.FILL)
        pBlanco = Paint(Paint.ANTI_ALIAS_FLAG)
        pBlanco!!.setColor(Color.WHITE)
    }

    // Para modificar el aspecto del EditText hay que reescribir este método
    override fun onDraw(canvas: Canvas) {
        //Invocamos al método de la superclase (EditText)
        super.onDraw(canvas)
        //Dibujamos el fondo negro del contador en la parte de arriba derecha
        pNegro?.let {
            canvas.drawRect((this.width - 30).toFloat(), 8F, (this.width - 8).toFloat(), 30F,
                it
            )
        }
        // Dibujamos el número de caracteres sobre el contador
        pBlanco?.let {
            canvas.drawText("" + this.text.toString().length, (this.width - 25).toFloat(), 21F,
                it
            )
        }
    }
}