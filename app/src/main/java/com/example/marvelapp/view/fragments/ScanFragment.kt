package com.example.marvelapp.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.example.marvelapp.R
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ScanFragment : Fragment() {

    private var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>? = null
    private var cameraExecutor: ExecutorService? = null
    private var previewView : PreviewView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previewView = view.findViewById(R.id.previewView)
        cameraExecutor = Executors.newSingleThreadExecutor()
        cameraProviderFuture = ProcessCameraProvider.getInstance(view.context)

        cameraProviderFuture?.addListener(Runnable {
            val cameraProvider = cameraProviderFuture?.get()
            bindPreview(cameraProvider)
        }, ContextCompat.getMainExecutor(view.context))
    }

    @SuppressLint("UnsafeExperimentalUsageError")
    private fun bindPreview(cameraProvider: ProcessCameraProvider?) {
        val preview: Preview = Preview.Builder()
            .build()
        val cameraSelector: CameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()
        preview.setSurfaceProvider(previewView?.surfaceProvider)

        cameraProvider?.bindToLifecycle(
            this as LifecycleOwner,
            cameraSelector,
            preview
        )
    }

}