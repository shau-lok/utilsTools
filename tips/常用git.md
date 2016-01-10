
# 开发中常用的git

###提交代码

```bash
git status 
git add .  
git commit -m "改了某东东"
git push origin master
git push --all origin
git pull 
git log
git log --graph #分支合并图
```

###回滚代码

```bash
git reflog  #获取 commit id ,记录本地的每一次命令
git reset --hard (commit id)
```

###分支

```bash
git checkout [master]  #换分支
git branch   #目前有多少分支
git branch -D local_branch  #删分支
git branch dev  #创建dev分支
```

###merge融合

```bash
git merge feature1 
```

###查看文件被谁改了

```bash
git log -p fileName
```

###项目进行到一半，需要切分支，保存当前状态

```bash 
git stash 
git stash list #看现有储藏
git stash apply stash@{2} #恢复更早的stash
git stash drop stash@{2}  
git stash pop     #从堆栈中恢复stash
```

###打tag

```bash
# add 标签 
git tag -a 6.5.0 -m "version 6.5.0"
# push tag to 仓库
git push --tags 
# delete 标签
git tag -d 6.5.0
# delete 标签 from 仓库
git push origin :refs/tags/6.5.0  #未试验

```


