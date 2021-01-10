package ec.dev.util;

public class Data {
	public void mapper(String entity, String tableName, String idColumn, String idProperty, Column ... columns) {
		String entityObject = entity.substring(0,1).toLowerCase() + entity.substring(1);
		Base.template("vm\\ibatis\\mapper.vm")
		.v("basePackage", Base.basePackage)
		.v("Entity", entity)
		.v("entityMap", entityObject + "Map")
		.v("entityObject", entityObject)
		.v("tableName", tableName)
		.v("idColumn", idColumn)
		.v("idProperty", idProperty)
		.v("columns", columns)
		.generate();
		Base.line();
	}
	public void mapperUpdate(String updateId, String entity, String tableName, String idColumn, String idProperty, Column ... columns) {
		String entityObject = entity.substring(0,1).toLowerCase() + entity.substring(1);
		Base.template("vm\\ibatis\\mapperupdate.vm")
		.v("updateId", updateId)
		.v("basePackage", Base.basePackage)
		.v("Entity", entity)
		.v("entityMap", entityObject + "Map")
		.v("entityObject", entityObject)
		.v("tableName", tableName)
		.v("idColumn", idColumn)
		.v("idProperty", idProperty)
		.v("columns", columns)
		.generate();
		Base.line();
	}
}