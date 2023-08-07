### 项目介绍
基于React + Spring Boot + Dubbo + Gateway的API接口开放调用平台。管理员可以接入并发布接口，可视化各接口调用情况;用户可以开通接口调用权限、浏览接口及在线调试，并通过客户端SDK轻松调用接口

1. 选用Spring Cloud Gateway 作为API网关，实现了路由转发、访问控制、流量染色，并集中处理签名校验、请求参数校验、接口调用统计等业务逻辑，提高安全性的同时、便于系统开发维护

2.  为解决多个子系统内代码大量重复的问题，抽象模型层和业务层代码为公共模块，并使用Dubbo RPC框架实现子系统间的高性能接口调用(实测单机qps达 xx)，大幅减少重复代码。

3.为防止接口被恶意调用，设计API签名认证算法，为用户分配唯一ak / sk以鉴权，保障调用的安全性、可溯源性(指便于统计接口调用次数)。

4. 为解决开发者调用成本过高的问题(须自己使用HTTP＋封装签名去调用接口，平均20行左右代码)，基于Spring Boot Starter开发了客户端SDK，一行代码即可调用接口，提高开发体验。