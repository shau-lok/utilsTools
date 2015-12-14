
# bitbucket 加 Tags

好处就在于每次版本的迭代仓库都能够很好的进行项目管理

如 [github上版本的release](https://github.com/benioZhang/MPost/releases)

bitbucket上有着同样的功能，就是加Tags

唯一不足的就是bitbucket把入口隐藏得狗屎深，``Downloads/Tags`` 并且不能在网页中加tags


## 再多学多一点``git``命令不会死的

使用 git 命令打tags:

```bash
# add 标签 
git tag -a 6.5.0 -m "version 6.5.0"
# push tag to 仓库
git push --tags 
# delete 标签
git tag -d 6.5.0
＃ delete 标签 from 仓库
git push origin :refs/tags/6.5.0  #未试验
```


