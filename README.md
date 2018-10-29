# 文件工具
* 读取文件目录
* 读取数据库
```flow
st=>start: 开始
e=>end: 结束
op1=>operation: 读取文件目录和数据库
op2=>operation: 校验打包
op3=>operation: 上传校验
op4=>operation: 导入失败目录
op5=>operation: 记录本次的导入节点
cond=>condition: 是否匹配
cond2=>condition: 是否还有未上传的包

st->op1(right)->cond
cond(no, right)->op4
cond(yes)->op2->cond2
cond2(no,right)->op3-cond2
cond2(yes)->op5->e

```