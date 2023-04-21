package jp.co.mixi.androidtraining.omikuji.data.repository

class FakeOmikujiRepository : OmikujiRepository {
    override fun getResult(): String {
        return "大吉"
    }
}
