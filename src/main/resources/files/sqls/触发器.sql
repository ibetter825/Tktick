#触发器
##tk_tag_art 新增一条tk_tag中对应的tag文章数增加一条
DROP TRIGGER
IF EXISTS t_after_insert_on_tk_tag_art;

CREATE TRIGGER t_after_insert_on_tk_tag_art AFTER INSERT ON tk_tag_art FOR EACH ROW
BEGIN
	UPDATE tk_tag SET art_num = art_num + 1 WHERE id = new.tag_id;
END;

##tk_tag_art 删除一条tk_tag中对应的tag文章数减少一条
DROP TRIGGER
IF EXISTS t_after_delete_on_tk_tag_art;

CREATE TRIGGER t_after_delete_on_tk_tag_art AFTER DELETE ON tk_tag_art FOR EACH ROW
BEGIN
	update tk_tag set art_num = art_num - 1 where id = old.tag_id and art_num > 0;
END;