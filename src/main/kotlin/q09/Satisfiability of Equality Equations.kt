package q09

/**
 * No.990
 */
class `Satisfiability of Equality Equations` {

    /**
     *
     */
    fun equationsPossible(equations: Array<String>): Boolean {
        val parent = IntArray(26){ it }
        val rank = IntArray(26){ it }
        for(equation in equations){
            if(equation[1] == '='){
                val n1 = equation[0] - 'a'
                val n2 = equation[3] - 'a'
                union(n1,n2,parent,rank)
            }
        }
        for(equation in equations){
            if(equation[1] == '!'){
                val n1 = equation[0] - 'a'
                val n2 = equation[3] - 'a'
                val p1 = find(n1,parent)
                val p2 = find(n2,parent)
                if(p1 == p2)
                    return false
            }
        }
        return true
    }
    private fun union(n1: Int,n2: Int, parent: IntArray, rank: IntArray){
        val p1 = find(n1,parent)
        val p2 = find(n2,parent)
        if(rank[p1] > rank[p2]){
            parent[p2] = p1
            rank[p1] += rank[p2]
        }else{
            parent[p1] = p2
            rank[p2] += rank[p1]
        }
    }
    private fun find(n: Int,parent: IntArray): Int{
        var p = parent[n]
        while(p != parent[p]){
            parent[p] = parent[parent[p]]
            p = parent[p]
        }
        return p
    }
    
    /**
     *
     */
    fun equationsPossible1(eqn: Array<String>): Boolean {
        val gr = HashMap<Char, ArrayList<Char>>()
        val colr = HashMap<Char, Int>()
        eqn.forEach{
            if (gr[it[0]] == null) gr[it[0]] = ArrayList()
            if (gr[it[3]] == null) gr[it[3]] = ArrayList()
            colr[it[0]] = -1; colr[it[3]] = -1
            if (it[1] == '=')
            {
                gr[it[0]]?.add(it[3])
                gr[it[3]]?.add(it[0])
            }
        }
        val visit = HashSet<Char>()
        fun color(nd: Char, col: Int) {
            visit.add(nd)
            colr[nd] = col
            for (i in gr[nd].orEmpty()) {
                if (!visit.contains(i)) color(i, col)
            }
        }
        var k = 0
        for (i in gr) {
            if (colr[i.key] == -1) color(i.key, k++)
        }
        eqn.forEach{
            if (it[1] == '=') {
                if (colr[it[0]] != colr[it[3]]) return false
            }
            else{
                if (colr[it[0]] == colr[it[3]]) return false
            }
        }
        return true
    }
}