package q17

import java.util.*

/**
 * No.1797
 */
class `Design Authentication Manager` {
}

class AuthenticationManager(timeToLive: Int) {

    val timeToLive = timeToLive

    class TokenInfo(
        val token: String,
        val time: Int
    ) {
        override fun hashCode() = token.hashCode()
        override fun equals(other: Any?): Boolean {
            return (other as? TokenInfo)?.let {it.token == token} == true
        }
        override fun toString() = "[$token - $time]"
    }

    val tokens = TreeSet<TokenInfo> {t1, t2 -> t1.time - t2.time}

    fun generate(tokenId: String, currentTime: Int) {
        val info = TokenInfo(tokenId, currentTime)
        tokens.add(info)
    }

    fun renew(tokenId: String, currentTime: Int) {
        cleanupExpired(currentTime)

        if (tokens.removeIf {it.token == tokenId} == false) {
            return
        }
        val info = TokenInfo(tokenId, currentTime)
        tokens.add(info)
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        cleanupExpired(currentTime)

        return tokens.size
    }

    private fun cleanupExpired(currentTime: Int) {
        val maxTime = currentTime - timeToLive
        while (tokens.isNotEmpty()) {
            val first = tokens.first()

            if (first.time <= maxTime) {
                tokens.remove(first)
            } else {
                break
            }
        }
    }

}