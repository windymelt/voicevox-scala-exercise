# voicevox-scala-exercise

このサンプルは、Scala Nativeを使ってVOICEVOX Core C APIを呼び出し、音声合成を実行します。生成される成果物は直接マシンが実行可能なネイティブバイナリです。

## VOICEVOX Coreをインストールする

付属のスクリプトでVOICEVOXを`/usr/local/lib/`以下にインストールできます。辞書ファイルなどは`./voicevox_core`以下に保存されます。

## バインディングを生成する

voicevox-coreのためのScalaバインディング/Cグルーコードは既に`./src/main/resources/scala-native/generated`と`./src/main/scala/generated`にコミット済みですが、APIが更新された場合は以下の手順を踏むことで再生成できます。

```sh
% sbt
> bindgenGenerateCSources
> bindgenGenerateScalaSources
```

生成されたScalaコードになぜか名前空間が衝突する箇所があるので、`aliases`オブジェクト内の`VoicevoxAccelerationMode`と`VoicevoxResultCode`をコメントアウトしてください。

## 依存

このサンプルでは、以下のライブラリに依存しています。

- SN bindgen (コンパイル時)
  - C ヘッダファイルからScalaの型定義を自動生成するため
- Circe (実行時)
  - JSONのパースのため
- record4s
  - 使いやすいextensible record typeのため
  - TypeScriptのオブジェクト型に近い書き味でScalaで書けるようになります

## ビルド

`sbt nativeLink`を実行すると`target/scala-3.3.0/voicevox-scala-exercise-out`が生成されます。

既存ではビルドオプションはデバッグビルドになっていますが、`build.sbt`を書き換えることでリリースビルドを行うことができます:

```scala
c.withLTO(LTO.thin)
  .withMode(Mode.releaseFast)
```

## 実行

`target/scala-3.3.0/voicevox-scala-exercise-out`を実行すると、ずんだもん(ノーマル)でサンプルボイスを生成し、`voicevox.wav`に保存します。同名のファイルがある場合、ファイルを上書きします。
