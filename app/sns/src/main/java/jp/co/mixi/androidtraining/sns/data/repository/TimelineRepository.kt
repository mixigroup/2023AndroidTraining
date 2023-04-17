package jp.co.mixi.androidtraining.sns.data.repository

import jp.co.mixi.androidtraining.sns.data.entity.Post
import jp.co.mixi.androidtraining.sns.data.entity.User
import kotlinx.coroutines.delay

interface TimelineRepository {
    suspend fun getTimeline(): List<Post>
}

class DefaultTimelineRepository : TimelineRepository {

    /**
     * 100件のランダムな投稿を2秒後に返します
     */
    override suspend fun getTimeline(): List<Post> {
        delay(2000)

        val authors = listOf(
            User(
                name = "太郎",
                photoUrl = "https://user-images.githubusercontent.com/24618660/225292560-4cf8b90d-4af4-4ccc-8cd1-bfa6c1b2e063.png"
            ),
            User(
                name = "花子",
                photoUrl = "https://user-images.githubusercontent.com/24618660/225292578-febabd19-63b2-45d3-9fa0-9d54c20a10e7.png"
            )
        )
        val contents = listOf(
            "こんにちは😊",
            "今日は忙しかった😣",
            "おやすみなさい、また明日！",
            "お腹すいた〜美味しいもの食べに行きたい🍖",
            "今日は天気いいから、外でランチ食べよう！",
            "今日は友達と遊びに行ってきました。楽しかった！🙌",
            "この前行ったカフェがおしゃれで、雰囲気が良かったです。",
            "この季節は花粉症がつらいですね。皆さんも気をつけましょう。",
            "お香をこう置こう。",
            "のり弁の利便性。",
            "お気に入りの音楽を聴きながらリラックス中♫",
            "一人暮らしを始めてから料理が趣味になりました！\n最初は不安でしたが、簡単なレシピから始めて少しずつ上達していくのが楽しいです。",
            "新しい職場に転職しました。初めは緊張しましたが、周りの人たちがとても親切で助けてくれるので、だんだんと馴染んできました。仕事内容も自分の興味に合っていて、やりがいを感じながら働いています。まだまだ慣れないことがたくさんあるので、毎日勉強しながら成長していきたいと思っています。",
            "先日、友達と一緒に旅行に行ってきました。\n目的地は温泉地で、ゆっくりと温泉に入りながらのんびり過ごすことができました。旅行中は天気も良くて、景色も最高でした。友達と一緒にいる時間がたくさんあったので、とても充実した時間を過ごすことができました。\n次回の旅行も楽しみにしています。",
        )
        return buildList {
            repeat(100) {
                add(Post(author = authors.random(), content = contents.random()))
            }
        }
    }
}
