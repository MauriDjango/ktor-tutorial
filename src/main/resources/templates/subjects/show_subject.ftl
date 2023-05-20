<#-- @ftlvariable name="subject" type="com.example.models.Subject" -->

<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${subject.name}
        </h3>
        <p>
            ${subject.description}
        </p>
        <hr>
        <p>
            <a href="/subjects/${subject.id}/edit">Edit subject</a>
        </p>
    </div>
</@layout.header>