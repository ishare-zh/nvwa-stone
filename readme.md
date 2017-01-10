
### 立项
nvwa-stone，女娲石，各种补位高手。

### 模块
- `nvwa-client`：对外提供的rpc服务
- `nvwa-common`：公共模板，比如工具类，对开源utils的封装等，后期可独立成一个project，让整个公司或团队维护同一个
- `nvwa-component`：业务中间件，如dubbo、zk、redis、mq等
- `nvwa-dal`：数据库交互，主要是获取数据接口
- `nvwa-deploy`：项目部署相关的脚本和文档
- `nvwa-oauth`：用户登录 & 认证中心，后期独立成服务接入
- `nvwa-service`：核心业务
- `nvwa-web`：web restful api

### 模块依赖
- `nvwa-client`
    + `nvwa-common`
- `nvwa-service`
    + `nvwa-client`
    + `nvwa-component`
    + `nvwa-dal`
- `nvwa-deploy` 
- `nvwa-oauth`
    + `nvwa-service`
- `nvwa-web`
    + `nvwa-oauth`

### 上古十大神器
- 东皇钟 `donghuang-bronze`
- 轩辕剑 `regulus-sword`
- 盘古斧 `pangu-ax`
- 炼妖壶 `demon-pot`
- 昊天塔 `heaven-tower`
- 伏羲琴 `fuxi-piano`
- 神农鼎 `shennong`
- 崆峒印 `kongtong-india`
- 昆仑镜 `kunlun-mirror`
- 女娲石 `nuwa-stone`

> 等集齐十大神器，就等着我们召唤神龙吧 ^-^
