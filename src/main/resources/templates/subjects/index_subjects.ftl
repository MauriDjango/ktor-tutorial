<#-- @ftlvariable name="subject" type="kotlin.collections.List<com.example.models.Subject>" -->

<!DOCTYPE html>
    <html lang="en">
<#import "../_layout.ftl" as layout />
<@layout.header>
    <#list subject?reverse as subject>
        <div>
            <h3>
                <a href="/articles/${subject.id}">${subject.name}</a>
            </h3>
            <p>
                ${subject.description}
            </p>
        </div>
    </#list>
    <hr>
    <p>
        <a href="/articles/new">Create subject</a>
    </p>
</@layout.header>