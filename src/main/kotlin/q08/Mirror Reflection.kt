package q08

/**
 * No.858
 */
class `Mirror Reflection` {

    val EPS: Double = 1e-6
    fun mirrorReflection(p: Int, q: Int): Int {
        var x = .0
        var y = .0
        var rx = p
        var ry = q
        while (!(close(x, p.toDouble()) && (close(y,.0)|| close(y, p.toDouble()))
                    || close(x, .0) && close(y, p.toDouble()))) {

            var t = 1e9
            if (-x / rx > EPS) t = minOf(t, -x / rx)
            if (-y / ry > EPS) t = minOf(t, -y / ry)
            if ((p - x) / rx > EPS) t = minOf(t, (p - x) / rx)
            if ((p - y) / ry > EPS) t = minOf(t, (p - y) / ry)

            x += rx * t
            y += ry * t

            if (close(x, p.toDouble()) || close(x, .0)) rx *= -1
            if (close(y, p.toDouble()) || close(y, .0)) ry *= -1
        }

        return when {
            close(x, p.toDouble()) && close(y, p.toDouble()) -> 1
            close(x, p.toDouble()) -> 0
            else -> 2
        }
    }

    fun close(x: Double, y: Double): Boolean = Math.abs(x - y) < EPS
}