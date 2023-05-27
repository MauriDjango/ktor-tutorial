<#-- @ftlvariable name="article" type="com.example.models.Article" -->
<#-- @ftlvariable name="subjects" type="kotlin.collections.List<com.example.models.Subject>" -->

<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${article.title}
        </h3>
        <p>
            ${article.body}
        </p>
        <p>
            <#list subjects?reverse as subject>
                <div>
                    <h3>
                        <a href="/articles/${subject.id}">${subject.name}</a>
                    </h3>
                    <p>
                        ${subject.description}
                    </p>
                </div>
            </#list>
        </p>
        <hr>
        <p>
            <a href="/articles/${article.id}/edit">Edit article</a>
        </p>
    </div>
</@layout.header>