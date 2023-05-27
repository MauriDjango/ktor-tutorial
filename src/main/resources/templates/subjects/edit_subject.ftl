<#-- @ftlvariable name="subject" type="com.example.models.Subject" -->

<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit subject</h3>
        <form action="/subjects/${subject.id}" method="post">
            <p>
                <input type="text" name="value" value="${subject.value}">
            </p>
            <p>
                <input type="text" name="name" value="${subject.name}">
            </p>
            <p>
                <textarea type="text" name="description" value="${subject.description}"></textarea>
            </p>
            <p>
                <input name="sectionId" value="${subject.sectionId}">
            </p>
            <p>
                <input type="text" name="order" value="${subject.order}">
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/subjects/${subject.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>