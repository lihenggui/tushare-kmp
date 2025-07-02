# TuShare Kotlin API 文档

本目录包含TuShare Kotlin API客户端的完整文档。

## 文档结构

- **API文档** (`api/`) - 由Dokka自动生成的API参考文档
- **样式文件** (`styles.css`) - 自定义的文档样式
- **静态资源** (`assets/`) - 文档中使用的图片和其他资源

## 生成文档

### 使用Gradle任务

项目提供了便捷的Gradle任务来生成和管理文档：

```bash
# 生成API文档
./gradlew generateDocs

# 本地预览文档
./gradlew serveDocs

# 清理生成的文档
./gradlew cleanDocs

# 准备发布到GitHub Pages
./gradlew publishDocs
```

### 手动使用Dokka

```bash
# 生成单模块文档
./gradlew :library:dokkaHtml

# 生成多模块文档
./gradlew dokkaHtmlMultiModule
```

## 本地预览

生成文档后，可以通过以下方式进行本地预览：

### 使用项目提供的服务器

```bash
./gradlew serveDocs
```

文档将在 `http://localhost:8080` 上可用。

### 使用其他HTTP服务器

```bash
# 使用Python HTTP服务器
cd docs/api
python3 -m http.server 8080

# 使用Node.js http-server
npx http-server docs/api -p 8080

# 使用PHP内置服务器
cd docs/api
php -S localhost:8080
```

## 发布到GitHub Pages

1. 运行文档生成任务：
   ```bash
   ./gradlew publishDocs
   ```

2. 提交并推送更改到GitHub：
   ```bash
   git add docs/
   git commit -m "Update API documentation"
   git push origin main
   ```

3. 在GitHub仓库设置中启用GitHub Pages：
   - 进入仓库的 Settings > Pages
   - 选择 "Deploy from a branch"
   - 选择 "main" 分支和 "docs" 文件夹
   - 点击保存

4. 文档将在几分钟后在以下地址可用：
   ```
   https://yourusername.github.io/tushare-kmp/
   ```

## 自定义文档

### 修改样式

编辑 `docs/styles.css` 文件可以自定义文档的外观。该文件包含：

- 颜色主题变量
- 导航栏样式
- 代码块样式
- 响应式设计规则

### 添加自定义内容

1. **模块描述**: 编辑 `library/Module.md` 添加模块级别的文档
2. **包文档**: 在包目录下创建 `package.md` 文件
3. **示例代码**: 在源代码中使用 `@sample` 标签引用示例

### 配置Dokka

Dokka的配置位于 `library/build.gradle.kts` 中的 `dokkaSourceSets` 部分。可以配置：

- 外部文档链接
- 源代码链接
- 平台特定设置
- 包含/排除规则

## 文档最佳实践

### KDoc注释规范

1. **类级别文档**：
   ```kotlin
   /**
    * 简短的类描述
    * 
    * 详细的类说明，包括用途、特性等。
    * 
    * @param param1 参数说明
    * @constructor 构造函数说明
    * @sample 示例代码
    * @see 相关类或方法
    */
   class MyClass(param1: String)
   ```

2. **方法级别文档**：
   ```kotlin
   /**
    * 方法的简短描述
    * 
    * 详细的方法说明。
    * 
    * @param param 参数说明
    * @return 返回值说明
    * @throws Exception 可能抛出的异常
    * @sample 示例代码
    */
   suspend fun myMethod(param: String): Result
   ```

3. **属性文档**：
   ```kotlin
   /**
    * 属性的说明
    */
   val myProperty: String
   ```

### 示例代码

使用 `@sample` 标签引用实际的示例代码：

```kotlin
/**
 * @sample com.example.MySamples.basicUsage
 */
fun myFunction()
```

### 交叉引用

使用 `@see` 标签创建类、方法、属性之间的链接：

```kotlin
/**
 * @see MyOtherClass
 * @see MyOtherClass.method
 * @see myProperty
 */
```

## 故障排除

### 常见问题

1. **文档生成失败**
   - 检查KDoc语法是否正确
   - 确保所有 `@sample` 引用的代码存在
   - 检查Gradle配置是否正确

2. **样式不生效**
   - 确保 `styles.css` 路径正确
   - 检查CSS语法
   - 清理并重新生成文档

3. **GitHub Pages不显示**
   - 确保GitHub Pages已正确配置
   - 检查 `.nojekyll` 文件是否存在
   - 等待几分钟让GitHub处理更新

### 调试技巧

1. 启用详细日志：
   ```bash
   ./gradlew dokkaHtml --info
   ```

2. 检查生成的HTML：
   ```bash
   # 打开生成的文档
   open docs/api/index.html  # macOS
   xdg-open docs/api/index.html  # Linux
   start docs/api/index.html  # Windows
   ```

## 更多资源

- [Dokka官方文档](https://kotlinlang.org/docs/dokka-introduction.html)
- [KDoc语法指南](https://kotlinlang.org/docs/kotlin-doc.html)
- [GitHub Pages文档](https://docs.github.com/en/pages)