# 共通のAI開発ルール

## 目的と現在の段階

- foodは、飲食店の注文・会員証・ポイントを共通の操作で使うアプリの構想です。
- 現在はAndroid向けデモの初期段階です。Kotlin + Jetpack Compose、単一のappモジュールを使います。
- 作業前にREADME.md、CONTRIBUTING.md、docs/decisions.mdと変更対象を確認してください。
- Google Docsには構想・未決事項・AIの提案も含まれます。すべてを採用済みの実装仕様とみなさないでください。

## 共同作業と判断

- 依頼の範囲に集中し、無関係な変更や他の人の作業の上書き・取り消しをしないでください。
- mainへ直接pushしないでください。作業ブランチとPRを使い、取り込みは人のレビューを経て行います。
- 未決事項は提案として示し、勝手に確定した仕様として実装しないでください。日常的な局所実装は既存方針の範囲で進めて構いません。
- 主要な技術・外部サービス・共有データ形式・公開や配布の方針は、2人の合意が必要です。
- 合意した方針の変更は、コードと一緒に共有文書へ反映してください。

## 実装

- コードの識別子は英語、説明・報告は原則日本語で書いてください。
- 色・文字スタイル・基本操作を共通化し、画面の文字列はAndroidリソースを使ってください。
- 依存関係はgradle/libs.versions.tomlで固定し、Gradle Wrapperを使ってください。
- 機能が必要になる前に、大規模な抽象化・空の層・モジュールを追加しないでください。
- デモでは架空データを使ってください。秘密鍵・認証情報・実際の個人情報をコミットしないでください。

## 検証と報告

- Androidコードやビルド設定の変更時は、可能な範囲で次を実行してください。
  - Windows: `.\gradlew.bat assembleDebug lintDebug testDebugUnitTest assembleDebugAndroidTest`
  - macOS / Linux: `./gradlew assembleDebug lintDebug testDebugUnitTest assembleDebugAndroidTest`
- UIを変更した場合は、接続済み実機またはエミュレーターで確認してください。利用できなければ未確認であることを明記してください。
- 実行していないテストを成功と報告しないでください。変更点・確認結果・残る制約を簡潔に報告してください。
- 文書だけの変更にAndroidビルドは不要です。

## Cloudflare

When interacting with Cloudflare, use the cf CLI unless the project has a Wrangler configuration file.
