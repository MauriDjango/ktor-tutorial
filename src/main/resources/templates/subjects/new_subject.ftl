<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Create subject</h3>
        <form action="/subjects" method="post">
            <p>
                <label>ID</label>
                <input type="text" name="id">
            </p>
            <p>
                <label>Value</label>
                <input type="text" name="value">
            </p>
            <p>
                <label>Name</label>
                <input type="text" name="name">
            </p>
            <p>
                <label>Description</label>
                <textarea type="text" name="description"></textarea>
            </p>
            <p>
                <label>Section ID</label>
                <input type="text" name="sectionId">
            </p>
            <p>
                <label>Order</label>
                <input type="text" name="order">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>