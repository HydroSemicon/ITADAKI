# food

飲食店ごとに分かれた注文・会員証・ポイントを、共通の操作で利用できるアプリを目指すプロジェクトです。名称は仮称です。

現在は **Android向けデモの初期開発段階** です。架空の店舗を使って、まず2人で画面と操作感を検証します。

## 現在できること

- Kotlin + Jetpack Compose製のアプリを起動する。
- 架空の2店舗を共通のカードで表示する。
- ライト／ダークテーマとCompose Previewで画面を確認する。

注文、会員登録、ポイント、決済、位置情報、通信、データ永続化は未実装です。実店舗への注文や個人情報の取り扱いは行いません。

## 開発環境

| 項目 | 固定値・方針 |
| --- | --- |
| IDE | Android Studio（AGP 8.13対応の安定版。Otter 2025.2.1以降を目安） |
| JDK | 17（Android Studio同梱JDKの利用も可。Gradle JDKを確認する） |
| Android SDK | Platform 36 / Build Tools 35.0.0 / Platform Tools |
| 対応下限 | Android 8.0 / API 26（デモ段階の暫定値） |
| compileSdk / targetSdk | 36 / 36 |
| Gradle / Android Gradle Plugin | 8.13 / 8.13.2 |
| Kotlin / Compose BOM | 2.2.21 / 2025.10.01 |

依存関係のバージョンは `gradle/libs.versions.toml`、Gradle本体はWrapperで管理します。これらは互換性を優先して固定した初期値で、最新版を意味しません。

## セットアップ

1. リポジトリをcloneし、Android Studioでリポジトリのルートを開きます。
2. SDK Managerから上記のSDKを導入し、Gradle Syncを実行します。
3. 実機の開発者向けオプションとUSBデバッグを有効にし、接続を許可します。Windowsでは端末用USBドライバーが必要な場合があります。
4. 実機またはAPI 26以上のエミュレーターを選び、`app`をRunします。

Android StudioはSDKの場所を `local.properties` に保存します。このファイルは共有しません。CLIを使う場合は `JAVA_HOME` と `ANDROID_HOME` を各自の環境に設定してください。初回ビルドには依存関係を取得するネット接続が必要です。

### コマンド（Windows PowerShell）

```powershell
.\gradlew.bat assembleDebug
.\gradlew.bat lintDebug testDebugUnitTest assembleDebugAndroidTest
.\gradlew.bat installDebug
.\gradlew.bat connectedDebugAndroidTest
```

`installDebug` と `connectedDebugAndroidTest` には接続済みの端末または起動済みエミュレーターが必要です。macOS / Linuxでは `./gradlew` を使います。

APKは `app/build/outputs/apk/debug/app-debug.apk` に生成されます。デモ用の仮application IDは `io.github.hydrosemicon.food`、debug版には `.debug` が付きます。本番の配布ID・署名・配布方式は未決定です。

現時点の自動テストは起動画面のAndroid UIスモークテストです。ローカル単体テストはまだありません。CIではビルド・Lint・テストAPKの生成を行い、端末上のテストは各自で実行します。

## ディレクトリ

```text
app/src/main/
  java/io/github/hydrosemicon/food/
    MainActivity.kt          # Androidの入口
    FoodApp.kt               # アプリのルートUI
    model/                  # 画面間で共有するデータ型
    data/demo/              # 架空データ
    ui/home/                # ホーム画面
    ui/theme/               # 共通テーマ
  res/                      # 文字列・アイコン・Androidテーマ
app/src/androidTest/        # 端末上のUIテスト
gradle/                     # バージョンカタログとWrapper
docs/                       # 合意済みの決定・デモの範囲
.github/                    # CIとPRテンプレート
```

画面数やデータ処理が増えた段階で、状態管理・API・保存処理を追加します。初期状態では単一の `app` モジュールとし、用途のない抽象化や空のモジュールは作りません。

## 共同開発

- 人向けの手順: [CONTRIBUTING.md](CONTRIBUTING.md)
- Codex / Claude共通の指示: [AGENTS.md](AGENTS.md)
- 採用済みの方針・未決事項: [docs/decisions.md](docs/decisions.md)
- 構想・議論の資料: [Google Docs](https://docs.google.com/document/d/1fRT-ViSa-7zlc6I1PmqLkYUcb9DDDZblxtI70q9KA-k/edit)

構想書やAIの提案のすべてが実装対象ではありません。合意した実装仕様をリポジトリに記録し、変更はPRで共有します。

## ライセンス

現在はOSSライセンスを採用していません。[LICENSE](LICENSE)を参照してください。依存ライブラリおよびGradle Wrapperには、それぞれのライセンスが適用されます。コード・デザインの権利帰属や将来の事業主体への移管は、2人で別途合意します。
