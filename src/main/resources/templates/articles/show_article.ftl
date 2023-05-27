<#-- @ftlvariable name="article" type="com.example.models.Article" -->
<#-- @ftlvariable name="subjects" type="kotlin.collections.List<com.example.models.Subject>" -->

<#import "../_layout.ftl" as layout />
<@layout.header>
    <div class="article-container">
        <div class="article">
            <h3 class="article-title">
                <a href="/articles/${article.id}">${article.title}</a>
            </h3>
            <p class="article-body">
                ${article.body}
            </p>
        </div>
        <div class="subjects">
            <h4>Subjects:</h4>
            <ul>
                <#list subjects as subject>
                    <li>
                        <h5 class="subject-name">
                            <a href="/subjects/${subject.id}">${subject.name}</a>
                        </h5>
                        <p class="subject-description">
                            ${subject.description}
                        </p>
                    </li>
                </#list>
            </ul>
        </div>
    </div>
    <hr>
    <p>
        <a href="/articles/${article.id}/edit">Edit article</a>
    </p>
</@layout.header>

<link rel="stylesheet" href="../../css/show_article.css">
