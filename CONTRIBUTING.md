# 共同開発の手順

## 着手から取り込みまで

1. Issueに目的・対象範囲・完了条件・担当者を記録します。小さな作業はPR本文で代用できますが、同じ場所を変更しそうなら着手前に相談します。
2. 最新の `main` から作業ブランチを作ります。例: `feature/store-list`、`fix/cart-total`、`codex/android-foundation`。
3. 1つの目的に絞って変更し、無関係な整形や他の人の作業を混ぜません。
4. ビルド・Lint・変更に必要なテストを実行します。画面を変更した場合は、実機またはエミュレーターで確認し、画像と端末・OSをPRに記録します。
5. PRを作成し、もう1人が確認してから `main` に取り込みます。AIのレビューは補助とし、最終判断は人が行います。

`main` への直接push・force pushは行いません。ブランチ保護と必須レビューはGitHub側で別途設定します。この文書やCIファイルを置いただけでは保護は有効になりません。

## コードと環境

- アプリ本体はKotlin、UIはJetpack Compose、ビルド設定はKotlin DSLを使います。
- 識別子は英語、説明・Issue・PR・共有ドキュメントは原則日本語を使います。
- `.editorconfig` と `.gitattributes` に従います。端末依存のパス・IDE設定・署名鍵は共有しません。
- GradleはWrapperを使い、依存関係のバージョンは `gradle/libs.versions.toml` で固定します。動的バージョンやSNAPSHOTは使いません。
- 色や文字スタイルは共通テーマに、画面の文字列はAndroidリソースに置きます。
- 主要なライブラリ、バックエンド、共有データ形式、公開・配布方法の変更は、実装前に2人で合意します。

## 検証

```powershell
.\gradlew.bat assembleDebug lintDebug testDebugUnitTest assembleDebugAndroidTest
.\gradlew.bat connectedDebugAndroidTest
```

前者は端末なしで実行できます。後者は端末上でUIスモークテストを実行します。実行できなかった確認は、理由とともにPRに記録します。まだ存在しない単体テストを実行済みと扱わないでください。

## 仕様とデータ

構想・議論はGoogle Docs、採用した開発上の決定は `docs/decisions.md` に残します。文書同士が食い違う場合は、実装前に確認します。AIの会話履歴や個人用メモだけで共有仕様を変更しません。

デモは架空データで進めます。実際の顧客情報、店舗アカウント、決済、外部サービスへの接続を追加する段階で、利用範囲・同意・管理責任を相談します。
