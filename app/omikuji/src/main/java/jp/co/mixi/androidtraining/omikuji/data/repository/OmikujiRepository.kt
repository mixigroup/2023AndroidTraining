package jp.co.mixi.androidtraining.omikuji.data.repository

interface OmikujiRepository {
    fun getResult(): String
}

class DefaultOmikujiRepository : OmikujiRepository {
    override fun getResult(): String {
        return listOf("大吉", "吉", "中吉", "小吉", "末吉", "凶", "大凶").random()
    }
}
