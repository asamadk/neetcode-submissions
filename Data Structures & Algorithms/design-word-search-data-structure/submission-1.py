class Node:
    def __init__(self):
        self.children = {}
        self.isEnd = False
        
class WordDictionary:

    def __init__(self):
        self.root = Node()

    def addWord(self, word: str) -> None:
        cur = self.root

        for letter in word:
            if letter not in cur.children:
                cur.children[letter] = Node()
            cur = cur.children[letter]
        cur.isEnd = True

    def search(self, word: str) -> bool:
        return self.dfs(0, self.root, word)

    def dfs(self, i, node, word) -> bool:
        if i >= len(word):
            return node.isEnd
        
        letter = word[i]

        if letter == ".":
            for child in node.children.values():
                if self.dfs(i+1, child, word):
                    return True
            return False
        
        if letter in node.children:
            return self.dfs(i+1, node.children[letter], word)

        return False
