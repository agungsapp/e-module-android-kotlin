package com.sanca.module

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TentangFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TentangFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_tentang, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recylerTentang)

        val names = listOf<String>(
            "Dr. satu .M.pd",
            "Dr. satu .M.pd",
            "Dr. satu .M.pd",
            "Dr. satu .M.pd",
            "Dr. satu .M.pd",
        )

        val images = listOf<Int>(
            R.drawable.tentang_1,
            R.drawable.tentang_2,
            R.drawable.tentang_3,
            R.drawable.tentang_4,
            R.drawable.tentang_5,
        )

        val myadapter = TentangAdapter(images, names)

        recyclerView.layoutManager = LinearLayoutManager(requireContext()) // Menggunakan requireContext() untuk mendapatkan konteks dari Fragment.
        recyclerView.adapter = myadapter

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TentangFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TentangFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}