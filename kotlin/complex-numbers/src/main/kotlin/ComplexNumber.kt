import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sin

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {

    val abs = Math.sqrt(real.pow(2) + imag.pow(2))

    operator fun plus(other: ComplexNumber) = ComplexNumber(real + other.real, imag + other.imag)

    operator fun minus(other: ComplexNumber) = ComplexNumber(real - other.real, imag - other.imag)

    operator fun times(other: ComplexNumber) = ComplexNumber(
            real * other.real - imag * other.imag,
            imag * other.real + real * other.imag)

    operator fun div(other: ComplexNumber) = ComplexNumber(
            (real * other.real + imag * other.imag) / (other.real.pow(2) + other.imag.pow(2)),
            (imag * other.real - real * other.imag) / (other.real.pow(2) + other.imag.pow(2)))

    fun conjugate() = ComplexNumber(real, -imag)

}

fun exponential(cmplx: ComplexNumber) = ComplexNumber(exp(cmplx.real) * cos(cmplx.imag), sin(cmplx.imag))