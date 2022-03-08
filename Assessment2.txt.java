import com.sun.javaws.exceptions.InvalidArgumentException
import kotlin.collections.HashSet


fun BitmapHoles(strArr: Array<String>): String {
    if(strArr.isEmpty())
        return "0" // optional

    val rowSize = strArr[0].length
    var groupsCount = 0
    var index = 0
    val roots = HashSet<Pair<Int, Int>>()

    while(index < rowSize) {
        var previousValue: Char? = null
        for((rowNum, row) in strArr.withIndex()) {
            if(row.length != rowSize)
                throw InvalidArgumentException(arrayOf("invalid matrix format")) // optional

            val isRoot = row[index] == '0' && previousValue != '0' && (index == 0 ||
                    row[index-1] != '0')
            val isCorrection = row[index] == '0' && previousValue == '0' && index > 0 && 
                row[index-1] == '0' && roots.contains(index-1 to rowNum)

            if(isRoot) {
                groupsCount++
                roots.add(index to rowNum)
            }
            else if(isCorrection) {
                groupsCount--
                roots.remove(index-1 to rowNum)
            }
            
            previousValue = row[index]
        }
        index++
    }

    return groupsCount.toString()
}