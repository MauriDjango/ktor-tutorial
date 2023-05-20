<#-- @ftlvariable name="article" type="com.example.models.Article" -->

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
            <#list articles?reverse as article>
                <div>
                    <h3>
                        <a href="/articles/${article.id}">${article.title}</a>
                    </h3>
                    <p>
                        ${article.body}
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