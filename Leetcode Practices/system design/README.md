## 系统设计学习资源
  
### 针对面试
* [Grokking-System-Design](https://github.com/lei-hsia/grokking-system-design)
* [Systems Design Youtube Playlist](https://www.youtube.com/watch?v=ZgdS0EUmn70&list=PL73KFetZlkJSZ9vTDSJ1swZhe6CIYkqTL)
* [系统设计题怎么考怎么答](https://www.youtube.com/watch?v=28n0DVP3U14)  
  
> 系统设计这块我最开始的时候也是无从下手，许多概念了解一点大概但是都没有深入学习，俗称“略懂”的状态，深究就暴露了。  
> 具体如何准备这块，地里的很多前辈都总结了很多好的帖子，我觉得比较好的资料包括如下：Grokking the system design Interview, Designing Data-Intensive Applications（https://vonng.gitbooks.io/ddia-cn/content/ ）, 以及一些 YouTube 视频（e.g., https://www.youtube.com/c/SystemDesignInterview/ )。资料可能大家都有，我的诀窍在于下面几点：  
> 1）重复直至真的理解。发现“书读百遍，其义自现”是真的（古人诚不我欺）。比如 DDIA 至少过一遍，Grokking 至少过5遍，第一遍可能过完什么印象都没有，后面好像每一遍都会有新的收获，然后可以逐渐自己思考如果自己遇到这种问题如何解决，会发现所有给的 design decision 都开始 make sense。跟刷题一样，与其看一大堆然后没啥印象不如多过几遍经典题目然后学会融会贯通。  
> 2）要做笔记并总结。很多系统设计题大概框架都是相似的，比如设计 facebook, twitter, instgram, pinterest，核心都是 feed generation，可以用 push（fanout/heavy write，fast read）也可以 pull（light write，slower read）模式，而且一般最优解都是两者结合。再比如如何处理 hot object问题，一遍情况下我们可以加 cache 直接从内存读取，或者使用不同的 sharding strategy 来平分流量。  
> 3）要学会抓关键得分点。这一点其实是目标公司 HR 在面试之前透露的系统设计的 evaluation standard，发现特别受用，具体有以下这些：（1）problem exploration，先问清楚设计的目的，有哪些功能性和非功能性的要求，怎么评价成功；（2）quantitative analysis，无非就是估算 QPS，内存，存储以及带宽需求；（3）completeness of the design，这个肯定是必须的，直接决定过不过；（4）ability to reason trade-offs，特别需要讲为什么选这个技术而不是其他的；（5）deep dive，重点关注数据/存储，以及如何解决 scale/bottleneck 等方面。面试过程要主动考虑这些点，整个流程如果每个点都有的话，应该不会有太大的偏差。  
> 透露下我自己的 timeline，全身心投入的时间可能有两个月，其中两周左右是在全天候学习没有上班，剩下的是正常上班晚上学习，可能 coding 和系统设计各占一半，轮流复习（今天系统设计明天 coding），最终拿到了两个 offer。顺便提下我没有参加任何 mock interview，我觉得大概的流程了解就可以了，而且计划总是赶不上变化，花相同的时间把问题真正搞懂是更有效的时间分配原则。PS，我考了个完全没准备过的题型但还是交出了一个还行的答案。  
  
以上来源：https://www.1point3acres.com/bbs/thread-692488-1-1.html  
  
#### 4S 分析法
* Scenario：场景 - 需要设计哪些（核心）功能（询问面试官、也可以自己想），需要承受多大的访问量？
* Service：服务 - 逻辑处理的整合，对于同一类问题的逻辑处理可以归并到一个服务中。这一步实际上就是将整个系统细分为若干个小的服务。
* Storage：存储 - 最重要的部分。根据每个服务的数据特性选择合适的存储结构，然后细化数据表结构。系统设计中可以选择的存储结构一般有三大类（数据库系统，文件系统，缓存系统）。其中数据库系统又分为关系型数据库（[SQL Database](./../../HackerRank%20Practises/sql/README.md)）和非关系型数据库（[NoSQL Database](./NoSQL.md)）。
* Scale：扩展 - 主要分两部分，一个是优化，包括解决设计缺陷，更多功能设计以及一些特殊情况如何处理；另一个是维护，包括系统的鲁棒性和扩展性，比如有一台服务器/数据库挂了怎么办？如果有流量暴增，如何扩展？  
  
最后，系统设计面试中需要注意的点：  
* Ask before design. 问清楚再动手设计，不要一上来就冲着一个巨牛的方案去设计；
* No more no less. 不要总想着设计最牛的系统，要设计够用的系统；
* Work solution first. 先设计一个基本能工作的系统，然后再逐步优化；
* Analysis is important than solution. 系统设计没有标准答案，记住答案是没用的，通过分析过程展示知识储备，权衡各种设计方式的利弊。  
  
系统设计面试主要考察以下几个方面：  
* 可行解 Work Solution、特定问题 Special Case、分析能力 Analysis、权衡 Tradeoff、知识储备 Knowledge Base  
  
以上参考[来源](https://juejin.cn/post/6863387461947506702)  
  
### 系统学习
* [Grok System Design Tutorial](https://github.com/yihaoye/data-structure-and-algorithm-study-notes/blob/master/Leetcode%20Practices/system%20design/grok_system_design_interview.pdf)
* [System-Design-Primer](https://github.com/donnemartin/system-design-primer)  
  
### 系统主要大类（其他系统皆可从中找到类似）
![](./System%20Category.png)  
![](./System%20Category%202.png)  
  
### 系统通用基础设施
摘录：https://www.cnblogs.com/ilinuxer/p/6697015.html  
* API 网关（负载均衡、身份验证、路由、缓存、速率限制、计费、监控、分析、安全防护）
* 业务应用和后端基础框架（MVC、IOC、ORM）
* 缓存（本地缓存即内存中的缓存机制：ConcurrentHashMap etc；分布式缓存即单独的缓存服务：Redis、Memcached etc）
* 数据库（SQL、NoSQL）
* 搜索引擎（全文搜索、Elasticsearch）
* 消息队列（RabbitMQ、Kafka）
* 文件存储（S3、Hadoop HDFS）
* 统一认证中心（用户的注册、登录验证、token 鉴权；内部信息系统用户的管理和登录鉴权；应用管理，应用的 secret 生成，应用信息的验证 - 如验证接口签名等）
* 单点登录系统（Central Authentication Service - CAS）
* 统一配置中心（Config Server、propeties、yaml）
* 服务治理框架（REST API、RPC）
* 统一调度中心（定时调度 cron job，如定时抓取数据、刷新状态等）
* 统一日志服务（log4j、logback、Kibana、CloudWatch）
* 数据基础设施（大数据：数据仓库；数据管道：Kafka、Kinesis；数据分析）
* 故障监控（系统监控、业务监控；Datadog、故障定位、警报等级、IM 或 oncall）
* 扩展（内部服务：包括大数据、构建交付工具、通用运行时服务类库、数据持久化、安全等）  
  
  
## DDIA（Designing Data-Intensive Applications）
### 数据密集型应用组件
现今很多应用程序都是数据密集型（data-intensive）的，而非计算密集型（compute-intensive）的。因此 CPU 很少成为这类应用的瓶颈，更大的问题通常来自数据量、数据复杂性、以及数据的变更速度。  
数据密集型应用通常由标准组件构建而成，标准组件提供了很多通用的功能；例如，许多应用程序都需要：  
* 存储数据，以便自己或其他应用程序之后能再次找到（数据库 database）
* 记住开销昂贵操作的结果，加快读取速度（缓存 cache）
* 允许用户按关键字搜索数据，或以各种方式对数据进行过滤（搜索索引 search indexes）
* 向其他进程发送消息，进行异步处理（流处理 stream processing）
* 定期处理累积的大批量数据（批处理 batch processing）  
  
  
### 非功能性需求
* 可靠性（Reliability）意味着即使发生故障，系统也能正常工作。故障可能发生在硬件（通常是随机的和不相关的），软件（通常是系统性的Bug，很难处理），和人类（不可避免地时不时出错）。容错技术可以对终端用户隐藏某些类型的故障。
* 可扩展性（Scalability）意味着即使在负载增加的情况下也有保持性能的策略。为了讨论可扩展性，首先需要定量描述负载和性能的方法（SLO、SLA）。简要了解了推特主页时间线的例子，介绍描述负载的方法，并将响应时间百分位点（中位数 p50 以及 p95，p99 和 p999 等等）作为衡量性能的一种方式。在可扩展的系统中可以添加处理容量（processing capacity）以在高负载下保持可靠。（监控相关：Telemetry / 遥测技术，一般是指从物理网元或者虚拟网元上远程实时高速采集数据，实现对网络实时、高速和更精细的监控技术。相比于传统的网络监控技术如 CLI、SNMP 等拉模式，Telemetry 通过推模式，主动向采集器上推动数据信息，提供更实时更高速更精确的网络监控功能。[更多参考](https://www.sdnlab.com/23887.html)）
* 可维护性（Maintainability）有许多方面，但实质上是关于工程师和运维团队的生活质量的。良好的抽象可以帮助降低复杂度，并使系统易于修改和适应新的应用场景。良好的可操作性意味着对系统的健康状态具有良好的可见性，并拥有有效的管理手段。  
  
