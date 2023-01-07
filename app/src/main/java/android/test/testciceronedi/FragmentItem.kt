package android.test.testciceronedi

import android.os.Bundle
import android.test.testciceronedi.databinding.FragmentItemBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.AppNavigator
import java.util.*



class FragmentItem : Fragment(){

    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navigation = requireContext().appComponent.navigation
        binding.uuid.text = UUID.randomUUID().toString()
        val counter = arguments?.getInt(COUNTER_ARG) ?: 0
        binding.counter.text = counter.toString()
        binding.forwardButton.setOnClickListener {
            navigation.openScreen(counter + 1)
        }
        binding.backButton.setOnClickListener {

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        private const val COUNTER_ARG = "COUNTER_ARG"

        fun newInstance(counter: Int):  FragmentItem = FragmentItem().apply {
            arguments = bundleOf(COUNTER_ARG to counter)
        }
    }


}

