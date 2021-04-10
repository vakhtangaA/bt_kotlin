fun main() {
    val f1 = Fraction(1F, 3F)

    val f2 = Fraction(2F, 6F)

    val added = f1.add(f2)
    val multiplied = f1.multiply(f2)

    println("$f1 added to $f2 = $added")
    println("$f1 multiplied to $f2 = $multiplied")

}

class Fraction(private val n: Float, private val d: Float) {
    private var numerator = n
    private var denominator = d

    fun add(other: Fraction): String {
        val denominator = d * other.d
        val numerator = n * other.d + d * other.n

        return simplify(numerator, denominator)
    }

    fun multiply(other: Fraction): String {
        val denominator = d * other.d
        val numerator = n * other.n

        return simplify(numerator, denominator)
    }

    fun simplify(n: Float = numerator, d: Float = denominator): String {
        var i = 1
        var gcd = 1

        while (i <= n && i <= d) {
            if (n % i == 0F && d % i == 0F) {
                gcd = i
            }
            ++i
        }

        val newNumerator = n / gcd
        val newDenominator = d / gcd

        return "$newNumerator/$newDenominator"
    }

    override fun toString(): String {
        return "$n/$d"
    }

}