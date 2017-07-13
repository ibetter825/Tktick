#type: 1 评论  type: 2 回复
(
	SELECT
		r.reply_id id,
		r.reply_time time,
		r.reply_cont cont,
		r.comt_id cid,
		'' aid,
		r.user_id uid,
		2 type
	FROM
		tk_reply r
	WHERE
		r.comt_id IN (
			SELECT
				foo.comt_id
			FROM
				(
					SELECT
						c.comt_id
					FROM
						tk_comment c
					WHERE
						c.art_id = 50
					LIMIT 0,
					5
				) AS foo
		)
	LIMIT 0,
	5
)
UNION ALL
	(
		SELECT
			c.comt_id id,
			c.comt_time time,
			c.comt_cont cont,
			'' cid,
			c.art_id aid,
			c.user_id uid,
			1 type
		FROM
			tk_comment c
		WHERE
			c.art_id = 50
		LIMIT 0,
		5
	)