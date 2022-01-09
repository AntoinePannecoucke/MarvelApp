package com.example.marvelapp.logic.analyzer

import android.util.Log
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.marvelapp.interfaces.ScanningResultListener
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class BarcodeAnalyzer(private val listener: ScanningResultListener) : ImageAnalysis.Analyzer {

    private var scanned = false

    @ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            val options = BarcodeScannerOptions.Builder()
                .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
                .build()
            val scanner = BarcodeScanning.getClient(options)

            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    if (!scanned) {
                        scanned = true
                        barcodes.firstOrNull().let { barcode ->
                            val rawValue = barcode?.rawValue
                            rawValue?.let {
                                Log.d("Barcode", it)
                                listener.onScanned(it)
                            }
                        }

                        imageProxy.close()
                        scanned = false
                    }
                }
                .addOnFailureListener {
                    // Task failed with an exception
                    // ...
                    imageProxy.close()
                }
        }
    }
}