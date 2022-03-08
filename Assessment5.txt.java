(function MatchingCharacters(str) { 
    var count  = 0
    for(var i = 0; i < str.length; i++){
      var charObj = {}
      var lastIdx = str.lastIndexOf(str[i])
      if(i == lastIdx) continue
      for(var j = i+1; j < lastIdx; j++){
        if(charObj[str[j]] == undefined) charObj[str[j]] = str[j]
      }
      if(count < Object.keys(charObj).length) count = Object.keys(charObj).length
    }
    console.log(count)
})('ahyjakh') //4 