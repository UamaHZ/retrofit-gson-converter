# retrofit-gson-converter
用于解决项目中接口报错时 data 字段数据类型和约定不一致造成的 gson 解析报错问题的自定义 Retrofit Gson Converter。
在 Retrofit 中，Gson 解析报错会回调到 onFailure 方法中，从而丢失接口返回的错误 msg 信息。

## 添加依赖
首先需要在项目的 `build.gradle` 文件中配置 [https://jitpack.io](https://jitpack.io) 的 maven 库：
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
其次在需要引用该的 module 的 `build.gradle` 中添加依赖：
```
compile 'com.github.UamaHZ:retrofit-gson-converter:{version}'
```

## 用法
用 `LMGsonConverterFactory` 替换原来的 `GsonConverterFactory` 即可。不同的是创建 `LMGsonConverterFactory` 对象需要额外传入 Gson 解析实体类基类的 `Class` 对象，
用于在 Gson 解析报错的时候将返回的 JSON 数据解析为基类类型，这样就可以保留接口返回的 status 和 msg 字段。典型用法如下：
```
retrofit = new Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(LMGsonConverterFactory.create(BaseResp.class))
        .client(buildClient())
        .build();
```
**注意：上面实例中的 `BaseResp.class` 需要传入自己项目中的基类 Class 对象，也要警惕项目中可能存在多个基类的情况，需要统一掉。**

典型的基类实现如下：
```
public class BaseBean {
    private String status;
    private String msg;

    ···
    省略 getter 和 setter
}
```
