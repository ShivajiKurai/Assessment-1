function TreeConstructor(strArr) 
{ 
["(1,2)", "(2,4)", "(7,2)"]
    const mapping = strArr.map(str => str.slice(1, str.length - 1).split(',').map(i => parseInt(i)));
    const tree = new Map();
    const allChildren = new Set();
    mapping.forEach(m => 
{
        if(!tree.has(m[1])) 
        {
            tree.set(m[1], []);
        }
        tree.get(m[1]).push(m[0]);
        allChildren.add(m[0]);
    });
    if(![...tree.values()].every(children => children.length < 3))
    {
        return 'false';
    }
    if([...tree.keys()].filter(k => !allChildren.has(k)).length > 1)
    {
        return 'false';
    }
    return 'true';
}
   
