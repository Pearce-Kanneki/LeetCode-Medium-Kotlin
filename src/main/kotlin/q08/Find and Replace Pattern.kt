package q08

/**
 * No.890
 */
class `Find and Replace Pattern` {

    /**
     * 較快的方法
     */
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        var answer = mutableListOf<String>()

        var patternSaver = mutableMapOf<Char, Int>()

        var patternIntRepresent = ""

        for(i in 0..pattern.length - 1){
            if(patternSaver.containsKey(pattern[i])){
                patternIntRepresent += patternSaver[pattern[i]]
            }else{
                patternIntRepresent += i.toString()
                patternSaver[pattern[i]] = i
            }
        }

        var examplePatterns = mutableMapOf<Char, Int>()

        for(i in 0..words.size - 1){
            var examplePattern = ""
            examplePatterns.clear()
            if(words[i].length == pattern.length){
                for(j in 0..words[i].length - 1){
                    if(examplePatterns.containsKey(words[i][j])){
                        examplePattern += examplePatterns[words[i][j]]
                    }else{
                        examplePattern += j.toString()
                        examplePatterns[words[i][j]] = j
                    }
                }
                if(examplePattern == patternIntRepresent) answer.add(words[i])
                print(examplePattern + "\n")
            }
        }

        return answer
    }

    /**
     *
     */
    fun findAndReplacePattern1(words: Array<String>, pattern: String): List<String> {
        val result = mutableListOf<String>()
        words.forEach {
            if (match(it, pattern) && match(pattern, it)) {
                result.add(it)
            }
        }

        return result
    }

    private fun match(word: String, pattern: String): Boolean {
        val map = HashMap<Char, Char>()
        for (i in word.indices) {
            if (!map.containsKey(word[i])) {
                map[word[i]] = pattern[i]
            } else if (map[word[i]] != pattern[i]) {
                return false
            }
        }

        return true
    }
}