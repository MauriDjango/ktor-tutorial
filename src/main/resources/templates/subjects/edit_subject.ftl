<#-- @ftlvariable name="subject" type="com.example.models.Subject" -->

<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit subject</h3>
        <form action="/subjects/${subject.id}" method="post">
            <p>
                <input type="text" name="value">
            </p>
            <p>
                <input type="text" name="name">
            </p>
            <p>
                <textarea type="text" name="description"></textarea>
            </p>
            <p>
                <textarea name="sectionId"></textarea>
            </p>
            <p>
                <input type="text" name="order">
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